import { mainAPI } from '../api/api'

const POST_EXPENSES = 'POST_EXPENSES'
const SET_EXPENSES = 'SET_EXPENSES'
const TOGGLE_IS_FETCHING = 'TOGGLE_IS_FETCHING'

const initialState = {
    expenses: [],
    costObject: {},
    isFetching: false
}


export const mainReducer = (state = initialState, action) => {
    switch (action.type) {
        case POST_EXPENSES:
            return { ...state, costObject: action.costObject }

        case SET_EXPENSES:
            return { ...state, expenses: action.expenses }

        case TOGGLE_IS_FETCHING:
            return { ...state, isFetching: action.isFetching }

        default:
            return state
    }
}

const setExpenses = (expenses) => ({ type: SET_EXPENSES, expenses })
const postExpenses = (costObject) => ({ type: POST_EXPENSES, costObject })
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