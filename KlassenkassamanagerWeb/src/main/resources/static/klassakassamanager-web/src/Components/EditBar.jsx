import React from "react";

function FunctionalButton({text}) {
    return (
        <button className={"btn btn-primary"} style={{width: '100%'}}>
            {text}
            
        </button>
    )
}

function AddButton() {
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
    return (
        <FunctionalButton text={"Delete"}/>
    )
}

function EditBar() {


    return (
        <div className={"row"}>
            <div className={"col-1"}></div>
            <div className={"col-2"}><AddButton/></div>
            <div className={"col-2"}><EditButton/></div>
            <div className={"col-2"}><IncreaseDebtButton/></div>
            <div className={"col-2"}><DepositButton/></div>
            <div className={"col-2"}><DeleteButton/></div>
        </div>
    )
}

export default EditBar;