"use client";

import { cn } from "@/lib/utils";
import { SidebarMenuButton, SidebarMenuItem } from "../ui/sidebar";
import { Calendar, Home, Inbox, User } from "lucide-react";
import { usePathname } from "next/navigation";
import Link from "next/link";

const mainItems = [
  {
    title: "Painel Geral",
    url: "/auth",
    icon: Home,
  },
  {
    title: "Agenda",
    url: "/auth/agenda",
    icon: Calendar,
  },
  {
    title: "Clientes",
    url: "/auth/clientes",
    icon: User,
  },
];

const SidebarItems = () => {
  const pathname = usePathname();
  return mainItems.map((item) => (
    <SidebarMenuItem key={item.title}>
      <SidebarMenuButton asChild>
        <Link
          href={item.url}
          className={cn({
            "bg-gray-300": pathname === item.url,
          })}
        >
          <item.icon />
          <span>{item.title}</span>
        </Link>
      </SidebarMenuButton>
    </SidebarMenuItem>
  ));
};

export default SidebarItems;
