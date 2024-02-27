import React, { useState } from "react";
import {GET, POST, PATCH, DELETE} from "../apiUtility";

function FunctionalButton({ modalId, text, onClick, disabled }) {
    return (
        <button className={"btn btn-primary"} style={{ width: '100%' }} onClick={onClick} disabled={disabled} type="button" data-bs-toggle="modal" data-bs-target={"#"+modalId}>
            {text}
        </button>
    )
}

let setStudents;
let setSelectedStudents;
let activeClass;

function ConfirmationModal({id, inputs, handleConfirm, title}) {

    return (
        <div className="modal fade" id={id} tabIndex="-1" aria-labelledby={id+"Label"}
             aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <form method={"post"} onSubmit={(event) => {event.preventDefault(); setSelectedStudents([]); handleConfirm(new FormData(event.target))}}>
                        <div className="modal-header">
                            <h1 className="modal-title fs-5" id={id+"Label"}>{title}</h1>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            {inputs && inputs.map((input, index) => (
                                <div key={index}>
                                    {input}
                                    <br/>
                                    <br/>
                                </div>
                            ))}
                        </div>
                        <div className="modal-footer">
                            <button type="button" className="btn btn-primary" data-bs-dismiss="modal" type={"submit"}>Confirm</button>
                            <button type="button" className="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

function AddButton() {
    const addStudent = async (data) => {
        console.log(activeClass)
        const newStudentData = {classId: -1, username:
                data.get('username')?data.get('username'):"Default",
            firstname: data.get('firstname')?data.get('firstname'):"FIRSTNAME",
            lastname: data.get('lastname')?data.get('lastname'):"LASTNAME",
            toPayAmount: 0, depositAmount: 0 };
        await POST(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/StudentWithUsername`, newStudentData);
        setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
    };

    const content = (
        [
            <input type={"text"} name={"firstname"} placeholder={"Firstname"}/>,
            <input type={"text"} name={"lastname"} placeholder={"Lastname"}/>,
            <input type={"text"} name={"username"} placeholder={"Username[Optional]"}/>
        ]
    )

    return (
        <>
            <FunctionalButton modalId={"addModal"} text={"Add Student"}/>
            <ConfirmationModal id={"addModal"} title={"Add Student"} inputs={content} handleConfirm={(data) => {addStudent(data)}}/>
        </>
    )
}

function ChangeNameButton({selectedStudents}) {
    const editStudent = async (data) => {
        console.log(activeClass)
        const newName = {firstname: data.get('firstname')?data.get('firstname'):selectedStudents[0].firstname,
            lastname: data.get('lastname')?data.get('lastname'):selectedStudents[0].lastname};
        console.log(newName)
        await PATCH(`http://localhost:8080/klassenkassa-manager/Student/${selectedStudents[0].id}/name`, newName);
        if (data.get('username'))
        {
            await PATCH(`http://localhost:8080/klassenkassa-manager/Student/${selectedStudents[0].id}/userName`, data.get('username') ? data.get('username') : "Default");
        }
        setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
    };

    const content = (
        [
            <input type={"text"} name={"firstname"} placeholder={"Firstname"}/>,
            <input type={"text"} name={"lastname"} placeholder={"Lastname"}/>,
            <input type={"text"} name={"username"} placeholder={"Username[Optional]"}/>
        ]
    )

    return (
        <>
            <FunctionalButton modalId={"changeModal"} text={"Edit Student"} disabled={selectedStudents.length !== 1}/>
            <ConfirmationModal id={"changeModal"} title={"Edit Student"} inputs={content} handleConfirm={(data) => editStudent(data)} />
        </>

    )
}

function IncreaseDebtButton({selectedStudents}) {
    const increaseDebt = async (data) => {
        console.log(activeClass)
        for (const selectedStudent of selectedStudents) {
            if (data.get('debt')) {
                await PATCH(`http://localhost:8080/klassenkassa-manager/Student/${selectedStudent.id}/debt`, parseFloat(data.get('debt')));
                setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
            }
        }
    };

    const content = (
        [
            <input type={"number"} name={"debt"} placeholder={"Debt"} min="0"/>,
        ]
    )

    return (
        <>
            <FunctionalButton modalId={"debtModal"} text={"Increase Debt"} disabled={selectedStudents.length <= 0}/>
            <ConfirmationModal id={"debtModal"} title={"Increase Debt"} inputs={content} handleConfirm={(data) => increaseDebt(data)} />
        </>
    )
}

function DepositButton({selectedStudents}) {
    const deposit = async (data) => {
        console.log(activeClass)
        for (const selectedStudent of selectedStudents) {
            if (data.get('depositValue')){
                await PATCH(`http://localhost:8080/klassenkassa-manager/Student/${selectedStudent.id}/depositValue`, parseFloat(data.get('depositValue')));
                setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
            }
        }
    };

    const content = (
        [
            <input type={"number"} name={"depositValue"} placeholder={"Deposit-Amount"} min="0"/>,
        ]
    )

    return (
        <>
            <FunctionalButton modalId={"depositModal"} text={"Deposit"} disabled={selectedStudents.length <= 0}/>
            <ConfirmationModal id={"depositModal"} title={"Deposit"} inputs={content} handleConfirm={(data) => deposit(data)} />
        </>
    )
}

function DeleteButton({selectedStudents}) {
    console.log(selectedStudents)
    const deleteStudents = async (data) => {
        for (const selectedStudent of selectedStudents) {
            await DELETE(`http://localhost:8080/klassenkassa-manager/Student/${selectedStudent.id}`);
            setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
        }
    };

    const content = (
        [
        <div>
            Are you sure you want to delete {selectedStudents.length} Students?
        </div>
        ]
    )

    return (
        <>
            <FunctionalButton modalId={"deleteModal"} text={"Delete"} disabled={selectedStudents.length <= 0}/>
            <ConfirmationModal id={"deleteModal"} title={"Delete"} inputs={content} handleConfirm={(data) => deleteStudents(data)}/>
        </>
    )
}


function EditBar({selectedStudents, activeClassBinding, setStudentsBinding, setSelectedStudentsBinding}) {
    setStudents = setStudentsBinding;
    setSelectedStudents = setSelectedStudentsBinding;
    activeClass = activeClassBinding;

    return (
        <div className={"row"}>
            <div className={"col-1"}></div>
            <div className={"col-2"}>
                <AddButton />
            </div>
            <div className={"col-2"}>
                <ChangeNameButton selectedStudents={selectedStudents}/>
            </div>
            <div className={"col-2"}>
                <IncreaseDebtButton selectedStudents={selectedStudents}/>
            </div>
            <div className={"col-2"}>
                <DepositButton selectedStudents={selectedStudents}/>
            </div>
            <div className={"col-2"}>
                <DeleteButton selectedStudents={selectedStudents} />
            </div>
        </div>
    )
}

export default EditBar;
