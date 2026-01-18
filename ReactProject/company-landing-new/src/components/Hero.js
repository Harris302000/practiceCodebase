function Hero() {
    return (
      <section>
        <h1>Welcome to My Company</h1>
        <p>We provide best IT solutions for your business.</p>
        <button>Get Started</button>
        <div className="hero-input">
        <label htmlFor="email">Email Address:</label>
        <input
          id="email"
          type="text"
          placeholder="Enter your email"
        />
      </div>
        
      </section>
    );
  }
  
  export default Hero;
  