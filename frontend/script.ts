const apiUrl: string = "http://localhost:8080/api/v1"
var resource: string = "/hello"

interface OutboundDto{
    message: string
}

async function fetchData(): Promise<void>  {
    try {
        const response = await fetch(apiUrl.concat(resource), {
            method: "GET",
            headers: {
                "Accept": "application/json"
            }
        });

        if (!response.ok){
            throw new Error(`ERROR ${response.status}`)
        }

        const dto: OutboundDto = await response.json();
        document.getElementById("output")!.textContent = dto.message;
        console.log("fetchData called");
    } catch (error) {
        console.error("Fetch error:", error);
    }
}

document.addEventListener("DOMContentLoaded", fetchData)