function Navbar({ onMenuClick, activePage }) {
  return (
    <nav>
      <h2>My Company</h2>
      <ul>
      <li
          className={activePage === "home" ? "active" : ""}
          onClick={() => onMenuClick("home")}
        >
          Home
        </li>

        <li
          className={activePage === "about" ? "active" : ""}
          onClick={() => onMenuClick("about")}
        >
          About
        </li>

        <li
          className={activePage === "services" ? "active" : ""}
          onClick={() => onMenuClick("services")}
        >
          Services
        </li>

        <li
          className={activePage === "contact" ? "active" : ""}
          onClick={() => onMenuClick("contact")}
        >
          Contact
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;