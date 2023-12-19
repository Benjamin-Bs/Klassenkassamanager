// Importiere die React-Bibliothek und die benötigten Komponenten
import React from 'react';
import { getStudentsFromClass } from '../apiUtility';

// Erstelle deine React-Komponente
function StudentTable() {
    // Rufe die Funktion 'getStudentsFromClass' auf, um die Schülerdaten zu erhalten
    const students = getStudentsFromClass();

    // Render-Funktion für die Tabelle
    const renderTable = () => {
        return (
            <table className="table table-dark table-hover">
                <thead>
                <tr>
                    <th scope="col">LN</th>
                    <th scope="col">Vorname</th>
                    <th scope="col">Nachname</th>
                    <th scope="col">Einzahlen</th>
                    <th scope="col">Bereits eingezahlt</th>
                    <th scope="col">Offener Betrag</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                {students.map((student, index) => (
                    <tr key={index}>
                        <th scope="row">{index + 1}</th>
                        <td>{student.firstname}</td>
                        <td>{student.lastname}</td>
                        <td>{student.depositAmount}</td>
                        <td>{student.toPayAmount}</td>
                        <td>{student.depositAmount - student.toPayAmount}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        );
    };

    // Gib die Tabelle zurück
    return (
        <div className="bd-example">
            <div
                data-bs-spy="scroll"
                data-bs-target="#navbar-example2"
                data-bs-root-margin="0px 0px -40%"
                data-bs-smooth-scroll="true"
                className="scrollspy-example bg-body-tertiary p-3 rounded-2"
                tabIndex="0"
                style={{ height: '800px', overflowY: 'scroll' }}
            >
                {renderTable()}
            </div>
        </div>
    );
}

// Exportiere die Komponente
export default StudentTable;
