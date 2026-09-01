import React from 'react'
import {BrowserRouter as Router,Routes,Route,useLocation,useNavigate} from 'react-router-dom'
import Home from './Home'
import About from './About'
import NavBar from './NavBar'
import Skills from './Skills'
import Projects from './Projects'
import Experience from './Experience'
import Contact from './Contact'
import { useEffect } from 'react'

const ReloadToHome = () => {

    const navigate = useNavigate();
    const location = useLocation();

    useEffect(() => {

        const navigation = performance.getEntriesByType("navigation")[0];

        if (
            navigation?.type === "reload" &&
            location.pathname !== "/"
        ) {
            navigate("/", { replace: true });
        }

    }, []);

    return null;
};

const RouterComp = () => {
  return (
    <>
    <Router>
      <ReloadToHome />
        <NavBar />
        <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/about' element={<About />} />
            <Route path='/skills' element={<Skills />} />
            <Route path='/projects' element={<Projects />} />
            <Route path='/experience' element={<Experience />} />
            <Route path='/contact' element={<Contact />} />
        </Routes>
    </Router>
    
    </>
  )
}

export default RouterComp