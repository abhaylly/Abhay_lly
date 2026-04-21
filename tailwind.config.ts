import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        background: "#ffffff",
        foreground: "#000000",
        primary: "#3b82f6",
        secondary: "#6b7280",
        accent: "#f59e0b",
        border: "#e5e7eb",
        destructive: "#ef4444",
      },
    },
  },
  plugins: [],
};
export default config;
