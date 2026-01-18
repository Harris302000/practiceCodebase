import { useState } from "react";
import Navbar from "./Navbar";
import Footer from "./Footer";
import About from "./About";
import Services from "./Services";
import Contact from "./Contact";
import Hero from "./Hero";
import homeBg from "./Images/HomePageBG.jpg";
import aboutBg from "./Images/AboutPageBG.jpg";
import servicesBg from "./Images/ServicesPageBG.jpg";
import contactBg from "./Images/ContactUSPageBG.jpg";

function HomePage(){


    const[activePage, setActivePage] = useState("home")

    const getBackground = () => {
        switch (activePage) {
          case "about":
            return aboutBg;
          case "services":
            return servicesBg;
          case "contact":
            return contactBg;
          default:
            return homeBg; // for "home"
        }
      };
    
    return (// AFTER LOGIN → LOAD OTHER PAGES

        <div className="app-layout"  style={{
            backgroundImage: `url(${getBackground()})`,
          }}>
            {/* <div className="main-content"> */}
            <Navbar onMenuClick={setActivePage} activePage={activePage} />
                {activePage === "home" && <Hero />}
                {activePage === "about" && <About />}
                {activePage === "services" && <Services />}
                {activePage === "contact" && <Contact />}
            {/* </div> */}
                
            
           <Footer />
            
        </div>
      
    );
    

}


export default HomePage;