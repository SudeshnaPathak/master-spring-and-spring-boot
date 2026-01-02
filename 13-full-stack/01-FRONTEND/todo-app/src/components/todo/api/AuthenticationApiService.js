import { apiClient } from './ApiClient.js'

export const executeBasicAuthenticationService = (token) => apiClient.get('/basicauth',
    {
        headers: {
            Authorization: token
        }
    }
)

export const executeJWTAuthenticationService = (username , password) => 
    apiClient.post('/authenticate',{username , password})