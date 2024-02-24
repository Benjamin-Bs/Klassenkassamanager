// Importiere die React-Bibliothek und die benötigten Komponenten
import React, { useEffect, useState } from 'react';
import { GET, DELETE, POST } from '../apiUtility'; // Annahme: DELETE und POST sind für API-Anfragen
import EditBar from "./EditBar";

// Erstelle deine React-Komponente
function StudentTable({ activeClass }) {
    const [students, setStudents] = useState([]);
    const [selectedStudents, setSelectedStudents] = useState([]);
    const [startingIndex, setStartingIndex] = useState(null);

    // Rufe die Funktion 'getStudentsFromClass' auf, um die Schülerdaten zu erhalten
    useEffect(() => {
        const fetchData = async () => {
            if (activeClass.id !== undefined) {
                const studentsData = await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`);
                setStudents(studentsData);
            }
        };

        fetchData();
    }, [activeClass]);

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
                    <th scope="col"> </th>
                </tr>
                </thead>
                <tbody>{fillTable()}</tbody>
            </table>
        );
    };

    const fillTable = () => {

        return students.map((student, index) => {
            const background = selectedStudents.includes(student) ? "bg-secondary" : "";
            return (
            <tr key={index} onMouseDown={() => mouseDown(index)} onMouseUp={() => mouseUp(index)}>
                <th className={background} scope="row">{index + 1}</th>
                <td className={background}>{student.firstname}</td>
                <td className={background}>{student.lastname}</td>
                <td className={background}>{student.toPayAmount}</td>
                <td className={background}>{student.depositAmount}</td>
                <td className={background}>{student.toPayAmount - student.depositAmount}</td>
                {/*Font Awesome hinzufügen*/}
                <td className={background}>{student.depositAmount >= student.toPayAmount ? "v" : "x"}</td>
            </tr>)
        });
    };

    const mouseDown = (selectedIndex) => {
        setStartingIndex(selectedIndex); // Setze den ausgewählten Schüler
        //console.log(student)
    };
    const mouseUp = (selectedIndex) => {
        const firstIndex = Math.min(startingIndex, selectedIndex);
        const lastIndex = Math.max(startingIndex, selectedIndex);

        const newStudents = students.filter((student, index) => (firstIndex <= index && index <= lastIndex));
        console.log(newStudents)
        setSelectedStudents(newStudents);
    };


    // Funktion zum Hinzufügen eines neuen Schülers
    const addStudent = async (activeClass) => {
        console.log(activeClass)
        // Annahme: 'activeClass.id' ist die aktive Klassen-ID
        const newStudentData = {classId: -1, userId: 1, firstname: 'Neuer', lastname: 'Schüler', toPayAmount: 0, depositAmount: 0 };
        await POST(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Student`, newStudentData);
        // Neu laden der Schülerdaten
        setStudents(await GET(`http://localhost:8080/klassenkassa-manager/Class/${activeClass.id}/Students`));
    };

    // Funktion zum Löschen eines Schülers
    const deleteStudent = async () => {
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
    };

    // Gib die Tabelle zurück
    return (
        <div className="bd-example">
            <div style={{ height: '5dvh' }}></div>
            <div
                data-bs-spy="scroll"
                data-bs-target="#navbar-example2"
                data-bs-root-margin="0px 0px -40%"
                data-bs-smooth-scroll="true"
                className="scrollspy-example bg-body-tertiary p-3 rounded-2"
                tabIndex="0"
                style={{ maxHeight: '75dvh', minHeight: '75dvh', overflowY: 'auto' }}
            >
                {renderTable()}
            </div>
            <EditBar
                onAddStudent={(() => addStudent(activeClass))} // Weitergabe der Funktion zum Hinzufügen eines Schülers
                onDeleteStudent={deleteStudent} // Weitergabe der Funktion zum Löschen eines Schülers
                studentsSelected={selectedStudents.length} // Weitergabe, ob ein Schüler ausgewählt ist
            />
        </div>
    );
}

// Exportiere die Komponente
export default StudentTable;
