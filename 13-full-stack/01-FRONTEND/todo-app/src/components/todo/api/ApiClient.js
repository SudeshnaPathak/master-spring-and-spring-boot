import axios from 'axios'

//Create an axios instance with custom configuration
export const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)