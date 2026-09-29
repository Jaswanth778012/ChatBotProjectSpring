import axios from "axios"

const baseURL = 'http://localhost:8086/api/v1'

export const sendMessagesToServer = async (messages, conversationId) => {

   const response = await axios.post(`${baseURL}/response`, messages, {
        headers: {
            ConversationId: conversationId,
        }
    });

    return response.data;
}