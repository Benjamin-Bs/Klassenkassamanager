import User from "./User";
import React, {useEffect, useState} from "react";
import {GET, POST} from "../apiUtility";
import StudentTable from "./StudentTable";
import Cookies from "js-cookie";
import {RiAddFill} from "react-icons/ri";
import createUtilityClassName from "react-bootstrap/createUtilityClasses";

function MainPart() {

    const [classes, setClasses] = useState([]);
    const [activeClass, setActiveClass] = useState({});

    useEffect(() => {
        const fetchData = async () => {
            const classData = await GET(`http://localhost:8080/klassenkassa-manager/User/${Cookies.get('username')}/Classes`);
            setClasses(classData);
            setActiveClass(classData[0])
        };

        fetchData();
    }, []);

    const fillList = () => {
        return classes.map((currentClass, index) => (
            <li className="nav-item">
                <button className={currentClass === activeClass ? "nav-link active" : "nav-link"} aria-current="page"
                        onClick={() => setActiveClass(currentClass)} style={{width: '100%'}}>
                    <svg className="bi me-2" width="16" height="16">
                        <use xlinkHref="#home"></use>
                    </svg>
                    {currentClass.department}
                    {Number(currentClass.ownerId) === Number(Cookies.get('userId')) ? " [owner]" : ""}
                </button>
            </li>
        ));
    };

    return (
        <>
            <div className="col-2">
                <div className="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
                     style={{width: '100%', height: '100%'}}>
                    <a href="/"
                       className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                        <svg className="bi me-2" width="40" height="32">
                            <use xlinkHref="#bootstrap"></use>
                        </svg>
                        <span className="fs-4">Klassen</span>
                    </a>
                    <hr/>
                    <ul className="nav nav-pills flex-column mb-auto">
                        {fillList()}
                    </ul>
                    {/*Add Modal*/}
                    <button className="btn btn-secondary" aria-current="page" style={{width: '100%'}}
                            data-bs-toggle="modal" data-bs-target="#BobMarley" onClick={() => console.log("kkkkl")}>
                        <svg className="bi me-2" width="16" height="16">
                            <use xlinkHref="#home"></use>
                        </svg>
                        <RiAddFill/>
                    </button>
                    <hr/>
                    <User/>
                </div>
            </div>
            {/*Modal*/}

            <div className="modal fade" id="BobMarley" tabIndex="-1" aria-labelledby={"BobMarleyLabel"}
                 aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id={"BobMarleyLabel"}>New Class</h1>
                            <button type="button" className="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <input id="departmentInput" placeholder="Class name"/>
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-primary" data-bs-dismiss="modal"
                                    type={"submit"} onClick={() => {

                                const departmentInput = document.querySelector('#departmentInput');
                                const departmentValue = departmentInput.value;
                                const currentDate = new Date();

                                const newClass = {
                                    ownerId: Number(Cookies.get('userId')),
                                    department: departmentValue,
                                    dateOfFounding: currentDate
                                };
                                POST("http://localhost:8080/klassenkassa-manager/Class/", newClass);

                            }}>Confirm
                            </button>
                            <button type="button" className="btn btn-danger"
                                    data-bs-dismiss="modal">Cancel
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div className="col-9">
                <StudentTable activeClass={activeClass}/>
            </div>
        </>
    );
}

export default MainPart;
