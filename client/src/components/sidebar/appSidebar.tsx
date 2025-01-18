import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarHeader,
  SidebarMenu,
} from "@/components/ui/sidebar";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

import { LogOut } from "lucide-react";
import SidebarItems from "./sidebarItems";

export function AppSidebar() {
  return (
    <Sidebar>
      <SidebarHeader>
        <div className="border-b pb-8 pt-4 px-2">
          <h1 className="p-2 pb-6 text-center text-2xl">Pilates App</h1>
          <div className="flex items-center justify-between px-2">
            <div className="flex items-center gap-2">
              <Avatar>
                <AvatarImage
                  src="https://github.com/shadcn.png"
                  alt="@shadcn"
                />
                <AvatarFallback>CN</AvatarFallback>
              </Avatar>
              <div>
                <h2>Administrador</h2>
                <div className="text-xs">Estúdio foobar</div>
              </div>
            </div>
            <LogOut size={20} />
          </div>
        </div>
      </SidebarHeader>
      <SidebarContent>
        <SidebarGroup className="pr-0">
          <SidebarGroupContent>
            <SidebarMenu>
              <SidebarItems />
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  );
}
