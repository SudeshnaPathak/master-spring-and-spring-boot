import axios from 'axios'

//Create an axios instance with custom configuration
export const apiClient = axios.create(
    {
        // CHANGE PORT TO 5000 for AWS REST APIs running on 5000
        baseURL: 'http://localhost:5000'
    }
)