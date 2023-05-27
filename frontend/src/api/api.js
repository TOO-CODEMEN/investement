import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://87.242.126.67:8080'
})


export const mainAPI = {
    getExpenses() {
        return instance.get(`/api/expenses`)
    },

    postExpenses(object) {
        return instance.post(`/api/expenses`, object)
    },

    getCosts(object) {
        return instance.post(`/api/totalcost`, object)
    }
}