import React from 'react';
import logo from './logo.svg';
import './css/App.css';
import Sidebar from './Components/MainPart';
import StudentTable from "./Components/StudentTable";
import Navbar from "./Components/Navbar";
import MainPart from "./Components/MainPart";
import Profile from "./Account/Account";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

function App() {
    sessionStorage.setItem('userName', 'Tom');
    sessionStorage.setItem('userId', 4);
    sessionStorage.setItem('password', '1234');

    return (
        <Router>
            <div className="App">
                <div className="row" style={{height: '10dvh', width: '100%'}}>
                    <Navbar/> {/* Navbar wird auf jeder Seite gerendert */}
                </div>
                <div className="row" style={{height: '90dvh', width: '100%'}}>
                    <Switch>
                        <Route path="/profile" component={Profile} /> {/* Route für das Profil */}
                        <Route path="/" component={MainPart} /> {/* Standard-Route */}
                    </Switch>
                </div>
            </div>
        </Router>
    );
}

export default App;
