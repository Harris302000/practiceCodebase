import React, { useEffect, useState } from 'react'

const Timer = () => {

    let [timer, setTimer] = useState(new Date());

    useEffect(() => {
     const timee =  setInterval(() => {
        setTimer(new Date());
      }, 1000);


      return () => clearInterval(timee);
    }, []);

    

  return (
    <>
        <p>{timer.toLocaleTimeString()}</p>
    </>
  )
}

export default Timer