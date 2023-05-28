import { firebaseApi } from "../api/firebase-api";

const POST_USER = 'POST_USER'
const GET_USER = 'GET_USER'
const TOGGLE_IS_FETCHING = 'TOGGLE_IS_FETCHING'

const initialState = {
    user: {},
    userCurrent: {},
    isFetching: false,
}

export const firebaseReducer = (state = initialState, action) => {
    switch (action.type) {

        case POST_USER:
            return { ...state, user: action.user }

        case GET_USER:
            return { ...state, userCurrent: action.userCurrent }
        
        case TOGGLE_IS_FETCHING:
            return {...state, isFetching: action.isFetching}

        default:
            return state
    }
}


const setUser = (userCurrent) => ({ type: GET_USER, userCurrent })
const postUser = (user) => ({ type: POST_USER, user })
const toggleIsFetching = (isFetching) => ({ type: TOGGLE_IS_FETCHING, isFetching })

export const requestPostUser = (object) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await firebaseApi.postFirebaseApi(object)
    if (response.status === 200) {
        dispatch(postUser(response.data))
        dispatch(toggleIsFetching(false))
        console.log(response.data)
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}

export const requestGetUser = (email) => async (dispatch) => {
    dispatch(toggleIsFetching(true))
    const response = await firebaseApi.getFirebaseApi()
    if (response.status === 200) {
        const users = Object.keys(response.data).map(key => ({ ...response.data[key], id: key }))
        const user = users.find(t => t.email === email)
        dispatch(setUser(user))
        dispatch(toggleIsFetching(false))
    } else {
        console.log(response)
        dispatch(toggleIsFetching(false))
    }
}