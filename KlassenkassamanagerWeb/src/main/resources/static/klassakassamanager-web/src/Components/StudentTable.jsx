function StudentTable() {
    return (
        <>
            <div className="bd-example" >

                <div
                    data-bs-spy="scroll"
                    data-bs-target="#navbar-example2"
                    data-bs-root-margin="0px 0px -40%"
                    data-bs-smooth-scroll="true"
                    className="scrollspy-example bg-body-tertiary p-3 rounded-2"
                    tabIndex="0"
                    style={{height: '800px', overflowY: 'scroll'}}
                >
                    {/* Table */}
                    <div className="bd-example">
                        <table className="table table-dark table-hover">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Larry the Bird</td>
                                <td>Birdowi</td>
                                <td>@twitter</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    );
}

export default StudentTable;
