import React from "react";
import { Link } from "react-router-dom";
import Loginpage from "./Loginpage";
import Button from "react-bootstrap/Button";
import NavBarComp from "./NavBarComp";
import welcome from "../assets/Banner/welcome-gif.png"

const Welcomepage = () => {

  return (
   
      <div className="welcome-Body">
        <div className="right-pane">
            <h1>Welcome to Our Store</h1>
            <p>Discover amazing products, explore our latest collections, and enjoy a seamless shopping experience. From everyday essentials to something special, we've got something for everyone.</p>
            <p>Shop Smart. Shop Easy. Shop With Us.</p>
            <h3>Everything You Love, All in One Place</h3>


          <section style={{width : '100%', display: "flex", justifyContent: 'space-around', marginTop : '100px'}}>

            

            <div className="list-div">
              <h3>✨ Featured Categories</h3>

              <ul>
                <li>Electronics</li>
                <li>Fashion</li>
                <li>Home & Kitchen</li>
                <li>Sports & Fitness</li>
                <li>Beauty & Personal Care</li>
                <li>Books & Accessories</li>
              </ul>
            </div>


            <div className="list-div">
              <h3>🔥 Short catchy list</h3>

              <ul>
                <li>Shop Smarter</li>
                <li>Save More</li>
                <li>Discover More</li>
                <li>Order Easily</li>
                <li>Get It Delivered</li>
                <li>Enjoy Your Purchase</li>
              </ul>
            </div>


            <div className="list-div">
              <h3>🛍️ Why Shop With Us?</h3>

              <ul>
                <li>Wide range of quality products</li>
                <li>Affordable and competitive prices</li>
                <li>Easy and secure online shopping</li>
                <li>Fast and reliable delivery</li>
                <li>Multiple payment options</li>
                <li>Easy returns and refunds</li>
                <li>Customer-friendly support</li>
              </ul>
            </div>


          </section>

          <section style={{width : '100%', display: "flex", justifyContent: 'space-around', marginTop : '50px'}}>
            
            <div className="list-div">
              <h3>🚀 What We Offer</h3>

              <ul>
                <li>Quality Products – Carefully selected products you can trust</li>
                <li>Best Prices – Great products at competitive prices</li>
                <li>Secure Payments – Safe and reliable payment options</li>
                <li>Fast Delivery – Get your orders delivered on time</li>
                <li>Easy Returns – Hassle-free return experience</li>
                <li>24/7 Support – We're here whenever you need us</li>
              </ul>
            </div>
          </section>
            

            
        </div>

      </div>
    
  );
};

export default Welcomepage;
