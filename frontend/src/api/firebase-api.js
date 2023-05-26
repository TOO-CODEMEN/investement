import axios from "axios";

const instance = axios.create({
    baseURL: 'https://react-calc-6f936-default-rtdb.firebaseio.com/'
})

export const firebaseApi = {

    postFirebaseApi(object) {
        return instance.post(`users.json`, object)
    }
}