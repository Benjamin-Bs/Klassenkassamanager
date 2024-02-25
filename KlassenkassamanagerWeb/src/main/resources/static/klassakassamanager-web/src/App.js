import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import Cookies from 'js-cookie';
import Navbar from './Components/Navbar';
import MainPart from './Components/MainPart';
import Login from './Components/Login/Login';
import Register from './Components/Register/Register';
import Profile from './Components/Account/Account';

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(!!Cookies.get('loggedIn')); // Überprüfen, ob der Benutzer angemeldet ist
    const [username, setUsername] = useState(Cookies.get('username') || ''); // Benutzername aus Cookies abrufen

    const handleLogin = () => {
        setIsLoggedIn(true); // Setzen des Anmeldestatus
    };

    const handleLogout = () => {
        setIsLoggedIn(false); // Setzen des Anmeldestatus
        Cookies.remove('username'); // Entfernen des Benutzernamens-Cookies
        Cookies.remove('loggedIn'); // Entfernen des loggedIn-Cookies
    };

    return (
        <Router>
            <div className="App">
                <div className="row" style={{ height: '10dvh', width: '100%' }}>
                    <Navbar isLoggedIn={isLoggedIn} handleLogout={handleLogout} username={username} /> {/* Navbar wird auf jeder Seite gerendert */}
                </div>
                <div className="row" style={{ height: '90dvh', width: '100%' }}>
                    <Switch>
                        <Route path="/login" render={() => <Login handleLogin={handleLogin} />} />
                        <Route path="/register" component={Register} />
                        <Route path="/profile" render={() => (
                            isLoggedIn ? <Profile /> : <Redirect to="/login" />
                        )} />
                        <Route exact path="/" render={() => (
                            isLoggedIn ? <MainPart /> : <Redirect to="/login" />
                        )} />
                    </Switch>
                </div>
            </div>
        </Router>
    );
}

export default App;