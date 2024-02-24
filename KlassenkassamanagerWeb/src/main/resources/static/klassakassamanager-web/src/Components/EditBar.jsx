import React, { useState } from "react";

function FunctionalButton({ text, onClick, disabled }) {
    return (
        <button className={"btn btn-primary"} style={{ width: '100%' }} onClick={onClick} disabled={disabled}>
            {text}
        </button>
    )
}

function ConfirmationModal({ isOpen, message, onCancel, onConfirm }) {
    return (
        <div className={"modal" + (isOpen ? " show" : "")} style={{ display: isOpen ? 'block' : 'none' }}>
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h4 className="modal-title">Confirmation</h4>
                        <button type="button" className="close" onClick={onCancel}>&times;</button>
                    </div>
                    <div className="modal-body">
                        {message}
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-primary" onClick={onConfirm}>Confirm</button>
                        <button type="button" className="btn btn-danger" onClick={onCancel}>Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

function EditBar({ onAddStudent, onDeleteStudent, isStudentSelected }) {
    const [isConfirmationOpen, setIsConfirmationOpen] = useState(false);
    const [confirmationMessage, setConfirmationMessage] = useState("");
    const [buttonText, setButtonText] = useState("");

    const handleButtonClick = (text) => {
        setButtonText(text);
        setConfirmationMessage(`Are you sure you want to ${text.toLowerCase()}?`);
        setIsConfirmationOpen(true);
    };

    const handleConfirm = () => {
        if (buttonText === "Add Student") {
            onAddStudent();
        } else if (buttonText === "Delete" && isStudentSelected) {
            onDeleteStudent();
        }
        setIsConfirmationOpen(false);
    };

    const handleCancel = () => {
        setIsConfirmationOpen(false);
    };

    return (
        <div className={"row"}>
            <div className={"col-1"}></div>
            <div className={"col-2"}>
                <FunctionalButton text={"Add Student"} onClick={() => handleButtonClick("Add Student")} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Edit Student"} onClick={() => handleButtonClick("Edit Student")} disabled={!isStudentSelected} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Increase Debt"} onClick={() => handleButtonClick("Increase Debt")} disabled={!isStudentSelected} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Deposit"} onClick={() => handleButtonClick("Deposit")} disabled={!isStudentSelected} />
            </div>
            <div className={"col-2"}>
                <FunctionalButton text={"Delete"} onClick={() => handleButtonClick("Delete")} disabled={!isStudentSelected} />
            </div>
            <ConfirmationModal
                isOpen={isConfirmationOpen}
                message={confirmationMessage}
                onCancel={handleCancel}
                onConfirm={handleConfirm}
            />
        </div>
    )
}

export default EditBar;
