import React, {useState} from 'react';
import {GET} from "../../apiUtility";

function Account() {

    const [file, setFile] = useState();
    function handleChange(e) {
        console.log(e.target.files);
        setFile(URL.createObjectURL(e.target.files[0]));
    }

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

                <div>
                    <h2>Add Image:</h2>
                    <input type="file" onChange={handleChange}/>
                    <img src={file}/>
                </div>
            </div>
        </div>
    );
}

export default Account;