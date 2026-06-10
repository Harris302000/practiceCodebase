import React, { useState } from "react";

let showPopupFunction;

export function showMessage(message) {
  showPopupFunction(message);
}

export default function MessagePopup() {
  const [showPopup, setShowPopup] = useState(false);
  const [message, setMessage] = useState("");

  showPopupFunction = (msg) => {
    setMessage(msg);
    setShowPopup(true);
  };

  return (
    <>
      {showPopup && (
        <div className="popup-overlay">
          <div className="popup-box">
            <h3>Message</h3>
            <p>{message}</p>
            <button onClick={() => setShowPopup(false)}>
              OK
            </button>
          </div>
        </div>
      )}
    </>
  );
}