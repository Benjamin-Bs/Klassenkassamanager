import React from 'react';
import logo from './logo.svg';
import './css/App.css';
import Sidebar from './Components/Sidebar';
import StudentTable from "./Components/StudentTable";
import Navbar from "./Components/Navbar";

function App() {
    return (
        <div className="App">

            <Navbar />
            <Sidebar />

            <div>
                <StudentTable />
            </div>

        </div>
    );
}

function MyButton() {
    return (
        <button>Hello There</button>
    );
}

export default App;
