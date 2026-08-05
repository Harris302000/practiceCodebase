import Content from "./components/Content";
import Header from "./components/Header";
import Footer from "./components/Footer";
import { createContext, useState } from "react";


export let customContext = createContext();


function App() {

  const [user, setUser] = useState({ userdets: { uName: "Agnes Harris", uAge: 25, uGender: "Male" } });

  console.log("App->User::" + JSON.stringify(user));


  return (
    <>

      <customContext.Provider value={user}>

        <Header />
        <Content />
        <Footer />

      </customContext.Provider>


    </>
  );
}

export default App;
