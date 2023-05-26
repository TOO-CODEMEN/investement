import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://example.com'
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