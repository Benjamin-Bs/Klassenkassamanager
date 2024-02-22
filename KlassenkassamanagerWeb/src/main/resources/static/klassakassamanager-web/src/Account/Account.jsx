import React from 'react';

function Account() {
    return (
        <div className="container">
            <h1>Your Account</h1>
            <div>
                <table className="table table-bordered">
                    <tr>
                        <th>Name:</th>
                    </tr>
                    <tr>
                        <td>Bob Boblio</td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                    </tr>
                    <tr>
                        <td>boblioooo@gmail.com</td>
                    </tr>
                </table>
            </div>
        </div>
    );
}

export default Account;