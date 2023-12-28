import React from 'react';
import logo from './logo.svg';
import './css/App.css';
import Sidebar from './Components/MainPart';
import StudentTable from "./Components/StudentTable";
import Navbar from "./Components/Navbar";
import MainPart from "./Components/MainPart";

function App(){
    sessionStorage.setItem('userName', 'Tom');
    sessionStorage.setItem('password', '1234');

    return (
        <div className="App">

            <div className="row" style={{height:'10dvh',width : '100%'}}>
                <Navbar />
            </div>
            <div className="row" style={{height:'90dvh',width : '100%'}}>
                <MainPart />
            </div>
        </div>
    );
}
export default App;
