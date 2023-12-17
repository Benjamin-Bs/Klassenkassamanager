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

            <div className="row" style={{width : '100%'}}>
                <div className="col-2">
                    <Sidebar />
                </div>
                <div className="col-9">
                    <StudentTable />
                </div>
            </div>

        </div>
    );
}
export default App;
