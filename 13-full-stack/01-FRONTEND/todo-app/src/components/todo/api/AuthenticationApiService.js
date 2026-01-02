import { apiClient } from './ApiClient.js'

export const executeBasicAuthenticationService = (token) => apiClient.get('/basicauth',
    {
        headers: {
            Authorization: token
        }
    }
)