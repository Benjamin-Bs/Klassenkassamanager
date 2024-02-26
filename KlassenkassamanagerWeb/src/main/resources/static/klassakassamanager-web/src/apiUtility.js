
async function GET(url) {
    return fetch(url)
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

export const POST = async (url, data) => {
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });
        //const responseData = await response.json();
        //return responseData;
    } catch (error) {
        console.error('Error while making POST request:', error);
        throw error;
    }
};

export const PATCH = async (url, data) => {
    try {
        const response = await fetch(url, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json',
            },
            body: (typeof data === 'object'?JSON.stringify(data):data),
        });
        //const responseData = await response.json();
        //return responseData;
    } catch (error) {
        console.error('Error while making DELETE request:', error);
        throw error;
    }
};

export const DELETE = async (url) => {
    try {
        const response = await fetch(url, {
            method: 'DELETE',
        });
        //const responseData = await response.json();
        //return responseData;
    } catch (error) {
        console.error('Error while making DELETE request:', error);
        throw error;
    }
};
