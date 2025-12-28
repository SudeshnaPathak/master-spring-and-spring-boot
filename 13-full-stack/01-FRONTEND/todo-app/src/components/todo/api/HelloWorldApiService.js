import axios from 'axios'

// export function retrieveHelloWorldBean(){
//      //axios to call REST API
//     return axios.get('http://localhost:8080/hello-world-bean') //Returns a Promise on GET request to the specified URL
// }

//Create an axios instance with custom configuration
const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export const retrieveHelloWorldBean = () => apiClient.get('/hello-world-bean')

export const retrieveHelloWorldPathVariable = (name) => apiClient.get(`/hello-world/path-variable/${name}`)