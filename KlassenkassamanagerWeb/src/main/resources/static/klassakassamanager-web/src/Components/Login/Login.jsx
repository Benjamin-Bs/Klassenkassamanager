import React, { useState } from 'react';
import { FaUser, FaLock } from "react-icons/fa";
import { Link, Redirect } from 'react-router-dom';
import Cookies from 'js-cookie'; // Importieren Sie Cookies aus dem js-cookie-Paket
import "../Login/css/Login.css"
import {GET} from "../../apiUtility";
const CryptoJS = require('crypto-js');


function Login({ handleLogin }) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loggedIn, setLoggedIn] = useState(false);

    const handleSubmit = (e) => {
        e.preventDefault();
        // Überprüfen Sie hier die Anmeldeinformationen
        console.log({"username": username,"password": password});
        GET(`http://localhost:8080/klassenkassa-manager/User/Id?username=${username}&password=${password}`)
            .then(result => {
                if (result !== -1) {
                    // Anmeldung erfolgreich, rufen Sie handleLogin auf
                    handleLogin();
                    setLoggedIn(true);
                    // Benutzerinformationen in Cookies speichern
                    Cookies.set('username', username);
                    Cookies.set('userId', result);
                    Cookies.set('loggedIn', true);
                } else {
                    alert('Invalid username or password');
                }
            })
            .catch(error => {
                alert('Invalid username or password');
            });

    };

    if (loggedIn) {
        // Wenn der Benutzer eingeloggt ist, leiten Sie ihn zur Hauptseite weiter
        return <Redirect to="/" />;
    }

    return (
        <>
            <section className="vh-100">
                <div className="container py-5 h-100">
                    <div className="row d-flex align-items-center justify-content-center h-100">
                        <div className="col-md-8 col-lg-7 col-xl-6">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
                                 className="img-fluid" alt="Phone image" />
                        </div>
                        <div className="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                            <h1>Login</h1>
                            <form onSubmit={handleSubmit}>
                                <div className="form-outline mb-4">
                                    <input type="text" id="username" className="form-control form-control-lg"
                                           placeholder="Username" value={username}
                                           onChange={(e) => setUsername(e.target.value)} />
                                </div>

                                <div className="form-outline mb-4">
                                    <input type="password" id="password"
                                           className="form-control form-control-lg" placeholder="Password"
                                           value={password} onChange={(e) => setPassword(e.target.value)} />
                                </div>

                                <button type="submit" className="btn btn-primary btn-lg btn-block">Sign in</button>

                                <div>
                                    <p>Don't have an account? <Link to="/register">Register</Link></p>
                                </div>
                                <div className="divider d-flex align-items-center my-4">
                                    <p className="text-center fw-bold mx-3 mb-0 text-muted">OR</p>
                                </div>

                                <a className="btn btn-primary btn-lg btn-block" style={{ backgroundColor: '#3b5998' }}
                                   href="#!"
                                   role="button">
                                    <i className="fab fa-facebook-f me-2"></i>Continue with Facebook
                                </a>
                                <br />
                                <a className="btn btn-primary btn-lg btn-block" style={{ backgroundColor: '#55acee' }}
                                   href="#!"
                                   role="button">
                                    <i className="fab fa-twitter me-2"></i>Continue with Twitter</a>

                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}

export default Login;