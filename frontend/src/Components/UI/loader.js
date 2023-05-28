import React from 'react'
import spin from '../../assets/img/icons/spin.svg'

export const Loader = () => {
  return (
    <div className='loader-wrapper'>
        <img src={spin} alt="Loader"/>
    </div>
  )
}