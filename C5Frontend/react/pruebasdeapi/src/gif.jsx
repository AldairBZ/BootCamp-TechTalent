// src/Gif.jsx
import { useEffect, useState } from "react";

const apiKey = "yZqdKlCmr7bWOZq0zPQZsfl0Oh6hx3Pg";

export default function Gif() {
  const [gifUrl, setGifUrl] = useState(null);

  useEffect(() => {
    fetch(`https://api.giphy.com/v1/gifs/random?api_key=${apiKey}`)
      .then((resp) => resp.json())
      .then(({ data }) => {
        const { url } = data.images.original;
        setGifUrl(url);
      })
      .catch(console.warn);
  }, []);

  return (
    <div>
      <h2>GIF aleatorio de Giphy</h2>
      {gifUrl && <img src={gifUrl} alt="Random Gif" />}
    </div>
  );
}