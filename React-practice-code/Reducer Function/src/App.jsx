import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import { useReducer } from 'react'

function App() {
  const [count, setCount] = useState(0)


  
  let reducerfunction = (state, action) => {
    console.log(action.type);
    console.log(state);
    
      
    let decflag = false;

    switch (action.type) {
      case "Increment":
        state ={...state, count: state.count + 1};
        break

      case "Decrement":
        state = {...state, count: state.count - 1};
        decflag = true;
        break 

        case "Reset":
          state = {...state, count: 0};
          break 

      default:
         return state
    }

    if(state.count >= 10 && state.count  < 20){
        state = {...state,message : 'Unlocked 10% off, click Increase to get 20% off'}
    } else if(state.count >= 20){
        state = {...state,message : 'Unlocked 20% off'}
    } else if(state.count < 10 && decflag){
      state = {...state,message : 'Reducing the offer?, Click Increase 10 times to get 10% off'}
    } else {
      state = {...state, message : 'Click Increase 10 times to get 10% off'}
    }

      return state;
  };



  let [state, dispatch] = useReducer(reducerfunction, {count : 0, message : ''})

  return (
    <>
      <section id="center">
        <div>
          <h1>Counter App</h1>
          <p>
            Count - {state.count}
          </p>
        </div>
        <button
          type="button"
          className="counter"
          onClick={() => dispatch({type : 'Increment'})}
        >
          Increase
        </button>

         <button
          type="button"
          className="counter"
          onClick={() => dispatch({type : 'Decrement'})}
        >
          Decrease
        </button>

        <button
          type="button"
          className="counter"
          onClick={() => dispatch({type : 'Reset'})}
        >
          Reset
        </button>


        <p>{state.message} </p>
      </section>

    </>
  )
}

export default App
