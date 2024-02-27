import React, { useState } from 'react';
import { Link, Redirect } from 'react-router-dom';
import { POST } from "../../apiUtility";

function Register() {
    const [isRegistered, setIsRegistered] = useState(false);

    const handleRegistration = () => {
        const nameInput = document.getElementById('name');
        const passwordInput = document.getElementById('password');
        const repeatPasswordInput = document.getElementById('repeat');
        const termsCheckbox = document.getElementById('terms');

        // Überprüfung, ob alle Felder ausgefüllt sind
        if (!nameInput.value || !passwordInput.value || !repeatPasswordInput.value) {
            alert('Please fill in all fields');
            return;
        }

        // Überprüfung, ob das Passwort mindestens 8 Zeichen lang ist
        if (passwordInput.value.length < 8) {
            alert('Password must be at least 8 characters long');
            return;
        }

        if (!/[A-Z]/.test(passwordInput.value)) {
            alert('Password must contain at least one uppercase letter');
            return;
        }

        // Überprüfung, ob das Passwort übereinstimmt
        if (passwordInput.value !== repeatPasswordInput.value) {
            alert('Passwords do not match');
            return;
        }

        // Überprüfung, ob die Nutzungsbedingungen akzeptiert wurden
        if (!termsCheckbox.checked) {
            alert('Please accept the terms of service');
            return;
        }

        const newStudent = {
            username: nameInput.value,
            password: passwordInput.value
        }

        POST("http://localhost:8080/klassenkassa-manager/User/", newStudent)
            .then(response => {
                // Wenn die Registrierung erfolgreich ist, setze den Zustand auf true
                setIsRegistered(true);
            })
            .catch(error => {
                console.error('Registration failed:', error);
            });
    }

    // Falls die Registrierung erfolgreich war, wird der Benutzer zur Login-Seite umgeleitet
    if (isRegistered) {
        return <Redirect to="/login" />;
    }

    return (
        <section className="vh-100 bg-image" style={{backgroundImage: "url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp')"}}>
            <div className="mask d-flex align-items-center h-100 gradient-custom-3">
                <div className="container h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-12 col-md-9 col-lg-7 col-xl-6">
                            <div className="card" style={{borderRadius: '15px'}}>
                                <div className="card-body p-5">
                                    <h2 className="text-uppercase text-center mb-5">Create an account</h2>

                                    <form>
                                        <div className="form-outline mb-4">
                                            <input type="text" className="form-control form-control-lg" placeholder="Name" id="name"/>
                                        </div>

                                        <div className="form-outline mb-4">
                                            <input type="password" className="form-control form-control-lg" placeholder="Password" id="password"/>
                                        </div>

                                        <div className="form-outline mb-4">
                                            <input type="password" className="form-control form-control-lg" placeholder="Repeat Password" id="repeat"/>
                                        </div>

                                        <div className="form-check d-flex justify-content-center mb-5">
                                            <input className="form-check-input me-2" type="checkbox" value="" id="terms"/>
                                            <label className="form-check-label" htmlFor="form2Example3g">
                                                I agree all statements in <a href="#!" className="text-body"><u>Terms of service</u></a>
                                            </label>
                                        </div>

                                        <div className="d-flex justify-content-center">
                                            <button type="button" className="btn btn-success btn-block btn-lg gradient-custom-4 text-body" onClick={handleRegistration}>Register</button>
                                        </div>

                                        <p className="text-center text-muted mt-5 mb-0">Have already an account? <Link to="/login" className="fw-bold text-body"><u>Login here</u></Link></p>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default Register;
