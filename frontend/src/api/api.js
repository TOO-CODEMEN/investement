import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://87.242.126.67:8080'
})


export const mainAPI = {
    getExpenses() {
        return instance.get(`/expenses`)
    },

    postExpenses(object) {
        return instance.post(`/expenses`, object)
    },

    getDownload() {
        return instance.get(`/expenses/download`)
    }
}