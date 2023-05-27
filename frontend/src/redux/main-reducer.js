import { mainAPI } from '../api/api'

const POST_EXPENSES = 'POST_EXPENSES'
const SET_EXPENSES = 'SET_EXPENSES'
const SET_COST = 'SET_COST'
const TOGGLE_IS_FETCHING = 'TOGGLE_IS_FETCHING'

const initialState = {
    expenses: [],
    costObject: {
        cost: '',
        data: ''
    },
    isFetching: false
}


export const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case POST_EXPENSES:
            return { ...state, expenses: action.expenses }

        case SET_EXPENSES:
            return { ...state, expenses: action.expenses }

        case SET_COST:
            return { ...state, costObject: action.costObject }

        case TOGGLE_IS_FETCHING:
            return { ...state, isFetching: action.isFetching }

        default:
            return state
    }
}

const setExpenses = (expenses) => ({ type: SET_EXPENSES, expenses })
const postExpenses = (expenses) => ({ type: POST_EXPENSES, expenses })
const setCosts = (costObject) => ({type: SET_COST, costObject})
const toggleIsFetching = (isFetching) => ({ type: TOGGLE_IS_FETCHING, isFetching })

export const requestExpenses = () => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getExpenses()
    if (response.status === 200) {
        dispatch(setExpenses(response.data))
        dispatch(toggleIsFetching(false))
        console.log(response.data)
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestPostExpenses = (object) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.postExpenses(object)
    if (response.status === 200) {
        dispatch(postExpenses(response.data))
        dispatch(toggleIsFetching(false))
        console.log(response.data)
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestCostsObject = (object) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await mainAPI.getCosts(object)
    if (response.status === 200) {
        dispatch(setCosts(response.data))
        dispatch(toggleIsFetching(false))
        console.log(response.data)
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}