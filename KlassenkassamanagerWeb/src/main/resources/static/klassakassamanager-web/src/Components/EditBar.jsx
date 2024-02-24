import React, { useState } from "react";
import {DELETE, GET, POST} from "../apiUtility";

function FunctionalButton({ text, onClick, disabled }) {
    return (
        <button className={"btn btn-primary"} style={{ width: '100%' }} onClick={onClick} disabled={disabled} type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
            {text}
        </button>
    )
}

function AddButton() {
    /*const addStudent = async (activeClass) => {
        console.log(activeClass)
        // Annahme: 'activeClass.id' ist die aktive Klassen-ID
        const newStudentData = {classId: -1, userId: 1, firstname: 'Neuer', lastname: 'Schüler', toPayAmount: 0, depositAmount: 0 };
        await POST(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Student`, newStudentData);
        // Neu laden der Schülerdaten
        setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
    };*/

    return (
        <FunctionalButton text={"Add Student"}/>
    )
}

function EditButton() {
    return (
        <FunctionalButton text={"Edit Student"}/>
    )
}

function IncreaseDebtButton() {
    return (
        <FunctionalButton text={"Increase Debt"}/>
    )
}

function DepositButton() {
    return (
        <FunctionalButton text={"Deposit"}/>
    )
}

function DeleteButton() {
    // Funktion zum Löschen eines Schülers
    /*const deleteStudent = async () => {
        if (selectedStudents.length !== 0) {
            for (const selectedStudent of selectedStudents) {
                // Annahme: 'selectedStudent.id' ist die ID des ausgewählten Schülers
                await DELETE(`http://localhost:8080/klassenkassa-manager/Student/${selectedStudent.id}`);
                // Neu laden der Schülerdaten
                const updatedStudentsData = await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`);
                setStudents(updatedStudentsData);
                setSelectedStudents([]); // Zurücksetzen des ausgewählten Schülers nach dem Löschen
            }
        }
    };*/

    return (
        <FunctionalButton text={"Delete"}/>
    )
}

function ConfirmationModal({ message, onConfirm }) {
    return (
        <div className="modal fade" id="exampleModal" tabIndex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h1 className="modal-title fs-5" id="exampleModalLabel">Confirmation</h1>
                        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div className="modal-body">
                        {message}
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-primary" data-bs-dismiss="modal" onClick={onConfirm}>Confirm</button>
                        <button type="button" className="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

function EditBar({ onAddStudent, onDeleteStudent, studentsSelected }) {
    const [confirmationMessage, setConfirmationMessage] = useState("");
    const [buttonText, setButtonText] = useState("");

    const handleButtonClick = (text) => {
        setButtonText(text);
        setConfirmationMessage(`Are you sure you want to ${text.toLowerCase()}?`);
    };

    const handleConfirm = () => {
        if (buttonText === "Add Student") {
            onAddStudent();
        } else if (buttonText === "Delete" && studentsSelected > 0) {
            onDeleteStudent();
        }
    };


    return (
        <div className={"row"}>
            <div className={"col-1"}></div>
            <div className={"col-2"}>
                <FunctionalButton text={"Add Student"} onClick={() => handleButtonClick("Add Student")} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Edit Student"} onClick={() => handleButtonClick("Edit Student")} disabled={studentsSelected !== 1} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Increase Debt"} onClick={() => handleButtonClick("Increase Debt")} disabled={studentsSelected <= 0} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Deposit"} onClick={() => handleButtonClick("Deposit")} disabled={studentsSelected <= 0} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Delete"} onClick={() => handleButtonClick("Delete")} disabled={studentsSelected <= 0} />
            </div>
            <ConfirmationModal
                message={confirmationMessage}
                onConfirm={handleConfirm}
            />
        </div>
    )
}

export default EditBar;
