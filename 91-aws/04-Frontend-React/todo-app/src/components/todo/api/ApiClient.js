import axios from 'axios'

//Create an axios instance with custom configuration
export const apiClient = axios.create(
    {
        // CHANGE PORT TO 5000 for AWS REST APIs running on 5000
        // baseURL: 'http://localhost:5000'
        baseURL: 'http://03-rest-api-fullstack-h2-env.eba-2dic4993.ap-south-1.elasticbeanstalk.com/'
    }
)