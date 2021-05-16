import { configureStore, getDefaultMiddleware } from "@reduxjs/toolkit";
import userReducer from "./user";

const store = configureStore({
  reducer: {
    user: userReducer,
  },
  middleware: getDefaultMiddleware({
    serializableCheck: false,
  }),
})
export type RootState = ReturnType<typeof store.getState>

export default store
