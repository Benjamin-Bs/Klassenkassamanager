/*const API_BASE_URL = 'http://localhost:8080/api'; // Deine Backend-URL hier

export const fetchData = async (endpoint) => {
    try {
        const response = await fetch(`${API_BASE_URL}/${endpoint}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return await response.json();
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};*/


async function GET(apiUrl) {

    /*const students = [
        {
            studentID: 5,
            firstname: "Bob",
            lastname: "Boblio",
            toPayAmount: 25,
            depositAmount: 30
        },
        {
            studentID: 2,
            firstname: "Puzzles",
            lastname: "00Z",
            toPayAmount: 224,
            depositAmount: 650
        },
        {
            studentID: 69,
            firstname: "Lazlo",
            lastname: "Cravensworth",
            toPayAmount: 453,
            depositAmount: 850
        }
    ];

    return students;*/
    return fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log(data)
            // Return the fetched data to be used in the next `then` block
            return data;
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            // You may want to rethrow the error to propagate it to the caller
            throw error;
        });

}

export {GET};
