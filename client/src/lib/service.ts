import ky from "ky";

const BASE_URL = "http://localhost:8080";

const api = ky.create({
  prefixUrl: BASE_URL,
});

export default api;
