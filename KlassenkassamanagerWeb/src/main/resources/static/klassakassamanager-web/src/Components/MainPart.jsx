import User from "./User";
import React, {useEffect, useState} from "react";
import {GET} from "../apiUtility";
import StudentTable from "./StudentTable";
import Cookies from "js-cookie";
import {RiAddFill} from "react-icons/ri";

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
                    {Number(currentClass.ownerId) === Number(sessionStorage.getItem("userId")) ? "[owner]" : ""}
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
                    <button className="btn btn-secondary" aria-current="page" style={{width: '100%'}} onClick={{/**/}}>
                        <svg className="bi me-2" width="16" height="16">
                            <use xlinkHref="#home"></use>
                        </svg>
                        <RiAddFill/>
                    </button>
                    <hr/>
                    <User/>
                </div>
            </div>
            <div className="col-9">
                <StudentTable activeClass={activeClass}/>
            </div>
        </>
    );
}

export default MainPart;
