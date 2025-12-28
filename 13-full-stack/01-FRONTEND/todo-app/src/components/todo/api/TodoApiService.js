import axios from 'axios'

//Create an axios instance with custom configuration
const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export const retrieveAllTodosForUsername = (username) => apiClient.get(`/users/${username}/todos`)