import { apiClient } from './ApiClient.js'

// export function retrieveHelloWorldBean(){
//      //axios to call REST API
//     return axios.get('http://localhost:8080/hello-world-bean') //Returns a Promise on GET request to the specified URL
// }

export const retrieveHelloWorldBean = () => apiClient.get('/hello-world-bean')

export const retrieveHelloWorldPathVariable = (name) => apiClient.get(`/hello-world/path-variable/${name}`)

