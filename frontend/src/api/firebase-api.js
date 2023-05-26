import axios from "axios";

const instance = axios.create({
    baseURL: 'https://react-calc-6f936-default-rtdb.firebaseio.com/',
})

export const firebaseApi = {

    async postFirebaseApi(object) {
        return await instance.post('/users.json', object)
    },

    getFirebaseApi() {
        return instance.get('/users.json')
    }
}