import { createContext, useState } from 'react'
import './App.css'
import Main from './Components/Maincontent'


export let productContext = createContext();

function App() {

  const [product, setProduct] = useState({
    productlist: [
      { id: 1, name: "Laptop", cost: 100000, checked: true },
      { id: 2, name: "TV", cost: 49000, checked: true },
      { id: 3, name: "Mobile", cost: 60000, checked: false }
    ]
  });



  return (
    <>
      <productContext.Provider value={product}>
        <Main />
      </productContext.Provider>

    </>
  )
}

export default App
